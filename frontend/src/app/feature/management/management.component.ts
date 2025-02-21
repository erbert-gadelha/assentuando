import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgFor, NgIf} from '@angular/common';

@Component({
  selector: 'app-management',
  imports: [NgFor, NgIf],
  templateUrl: './management.component.html',
  styleUrl: './management.component.scss'
})
export class ManagementComponent {
  private id:string|null = "-1";

  constructor(private route: ActivatedRoute) {}

  public title:string = "";

  public theathers:Theater[] = [
    {id:7, name:"sala de conferência"},
    {id:2, name:"anfiteatro"},
    {id:21, name:"auditório"},
  ];

  public seats:Seat[] = []
  public selected:Seat|null = null
  public focused:boolean = false
  @ViewChild('input') input: ElementRef|undefined;



  ngOnInit() {
    for (let i = 0; i < 15; i++) {
      this.seats.push({id:1, person:null, color:"white", createdAt:null})       
    }

    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
      console.log('ID:', this.id);

      if(this.id != null) {
        const id = Number.parseInt(this.id)
        for (let i = 0; i < this.theathers.length; i++)
          if(this.theathers[i].id == id) {
            this.title = this.theathers[i].name
            break;
          }
      }
    });
  }

  public onEnter(event: Event) {
    this.onClick(-1);
  }



  private formatter:Intl.DateTimeFormat  = new Intl.DateTimeFormat('pt-BR', {
    day:'2-digit', month:'2-digit', year:'numeric', hour: '2-digit', minute: '2-digit', hour12: false
  });


  public onMouseOver(id:number) {
    /*console.log("onMouseOver", id);
    console.log("focused", this.focused);
    console.log("selected", this.selected);*/

    if(this.focused)
      return;

    if(id < 0 || id >= this.seats.length)
      this.selected = null;
    else if(this.seats[id].person)
      this.selected = this.seats[id];
  }

  public reset() {
    if(this.input?.nativeElement)
      this.input.nativeElement.value = "";
  }
  
  
  public onClick(id:number) {

    if(id < 0 || id >= this.seats.length) {
      this.focused = false;

      if(this.selected != null) {
        let input:string = this.input?.nativeElement.value.trim();
        console.warn(`valor: "${input}"`);

        if(input) {
          this.selected.person = input;
          this.selected.createdAt = this.formatter.format(new Date().getTime());
          this.selected.color = "var(--color-0)"
        } else {
          this.selected.person = null;
          this.selected.createdAt = null;
          this.selected.color = "white"
        }
      }

      this.selected = null;
      return;
    }

    this.selected = this.seats[id];
    this.selected.color = "gray";
    this.focused = true;
  }
}

interface Theater {
  id:number,
  name:string,
}

interface Seat {
  id:number,
  person:string|null,
  color:any,
  createdAt:string|null
}
