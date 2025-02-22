import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from '../../shared/header/header.component';
import { NgFor} from '@angular/common';
import { RouterLink } from '@angular/router';

import { HttpClient } from '@angular/common/http';
import { environment } from '../../environment/environment';

@Component({
  selector: 'app-home',
  imports: [HeaderComponent, NgFor, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {

  constructor(private http : HttpClient) {}


  public theathers:Theater[] = [];

  ngOnInit() {
    this.http.get<Theater[]>(`${environment.host}/api/1/theater/`)
    .subscribe({
      next: (theaters) => this.theathers = theaters,
      error: (err) => console.error("Erro ao criar sala:", err)
    });
  }

  public async create() {
    const theaterName = `sala ${this.theathers.length}`
    this.http.post<Theater>(`${environment.host}/api/1/theater/${theaterName}`, {})
    .subscribe({
      next: (theater) => this.theathers.push(theater),
      error: (err) => console.error("Erro ao criar sala:", err)
    });
  }

  public delete(index:number):void {
    console.warn("deletar do backend.")
  }
}

interface Theater {
  id:number,
  name:string,
}
