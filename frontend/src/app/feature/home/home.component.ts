import { Component } from '@angular/core';
import { HeaderComponent } from '../../shared/header/header.component';
import { CommonModule, NgFor} from '@angular/common';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [HeaderComponent, NgFor, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {



  constructor(private r: Router) {
      this.router = r;
  }
  public router:Router|null = null;

  public theathers:Theater[] = [
    {id:7, name:"sala de conferência"},
    {id:2, name:"anfiteatro"},
    {id:21, name:"auditório"},
  ];

  public create():void {
    console.warn("criar no backend.")
    this.theathers.push({id:1, name: `sala ${this.theathers.length}` });
  }

  public delete(index:number):void {
    console.warn("deletar do backend.")
  }

  public navigateTo(index:number):void {
    this.router?.navigate([`/sala/${index}`])
  }
}

interface Theater {
  id:number,
  name:string,
}
