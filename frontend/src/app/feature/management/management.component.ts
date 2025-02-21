import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule, NgFor} from '@angular/common';
import { ChairSvgComponent } from '../../shared/chair-svg/chair-svg.component';

@Component({
  selector: 'app-management',
  imports: [NgFor, ChairSvgComponent],
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

  public seats:Seat[] = [
    {id:1, person:"Fulano"}, {id:2, person:"Sicrano"}, {id:3, person:"Williano"}, {id:4, person:"Ribriano"}, {id:5, person:"Marciano"}]
  //];


  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.id = params.get('id');
      console.log('ID:', this.id);

      if(this.id != null) {
        const id = Number.parseInt(this.id)
        for (let i = 0; i < this.theathers.length; i++) {
          if(this.theathers[i].id == id) {
            this.title = this.theathers[i].name
            break;
          }          
        }
      }
    });
  }
}

interface Theater {
  id:number,
  name:string,
}

interface Seat {
  id:number,
  person:string|null,
}
