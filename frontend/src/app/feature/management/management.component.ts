import { Component, ElementRef, inject, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgFor, NgIf} from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environment/environment';

@Component({
  selector: 'app-management',
  imports: [NgFor, NgIf],
  templateUrl: './management.component.html',
  styleUrl: './management.component.scss'
})
export class ManagementComponent implements OnInit  {
  private id:string|null = "-1";
  private readonly router = inject(Router);

  constructor(private route: ActivatedRoute, private http : HttpClient) {}

  public title:string = "";

  public theather:Theater = {id:-1, name:'', seats:[]};

  public selected:Seat|null = null
  public focused:boolean = false

  @ViewChild('input') input: ElementRef|undefined;



  ngOnInit() {
    const goBack = () => this.router.navigate(['']);


    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
      console.log('ID:', this.id);

      if(this.id == null) {
        goBack(); return;
      }

      const id = Number.parseInt(this.id)
      if(Number.isNaN(id)) {
        goBack(); return;
      }


      this.http.get<Theater>(`${environment.host}/api/1/theater/${id}`, {})
      .subscribe({
        next: (theater) => {
          this.theather = theater

          //this.theather.seats.forEach(seat => seat.color = seat.person='Erbert')
          this.theather.seats.forEach(seat => seat.color = seat.person==null?'white':'var(--color-0)')
          
          console.log("theater", this.theather)
        },
        error: (err) => console.error("Erro ao criar sala:", err)
      });
    });




    
  }

  public onEnter(event: Event) {
    this.onClick(-1);
  }



  private formatter:Intl.DateTimeFormat  = new Intl.DateTimeFormat('pt-BR', {
    day:'2-digit', month:'2-digit', year:'numeric', hour: '2-digit', minute: '2-digit', hour12: false
  });

  private setSeatValue(seatNumber:number, value:string|null) {
    const seat = this.theather.seats[seatNumber]
    if(value?.length == 0)
      value = null

    if(seat.person == value) {
      seat.color = seat.person?'var(--color-0)':'white'; return;
    }

    const refreshValues = (seat:Seat) => {
      const seat_:Seat = this.theather.seats[seat.seatNumber];
      seat_.person = seat.person;
      seat_.changedAt = seat.changedAt;
      seat_.color = seat.person?'var(--color-0)':'white';
    }

    
    this.http.put<Seat>(`${environment.host}/api/1/seat/${this.theather.id}/${seat.seatNumber}`, value)
      .subscribe({
        next: (seat) => refreshValues(seat),
        error: (err) => console.error("Erro ao alterar poltrona:", err)
      });
  }


  public onMouseOver(id:number) {
    /*console.log("onMouseOver", id);
    console.log("focused", this.focused);
    console.log("selected", this.selected);*/

    if(this.focused)
      return;

    if(id < 0 || id >= this.theather.seats.length)
      this.selected = null;
    else if(this.theather.seats[id].person)
      this.selected = this.theather.seats[id];
  }

  public reset() {
    if(this.input?.nativeElement)
      this.input.nativeElement.value = "";
  }
  
  
  public onClick(id:number) {
    if(id < 0 || id >= this.theather.seats.length) {
      this.focused = false;
      if(this.selected != null) {
        let input:string = this.input?.nativeElement.value.trim();
        this.setSeatValue(this.selected.seatNumber, input);
      }
      this.selected = null;
      return;
    }

    this.selected = this.theather.seats[id];
    this.selected.color = "gray";
    this.focused = true;
  }
}

interface Theater {
  id:number,
  name:string,
  seats:Seat[],
}


interface Seat {
  id:number,
  person:string|null,
  seatNumber:number,
  thearId:number|null
  theaterName:string|null
  changedAt:any|null
  color:any,
}
