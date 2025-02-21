import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './feature/home/home.component';
import { ChairSvgComponent } from './shared/chair-svg/chair-svg.component';
import { HeaderComponent } from './shared/header/header.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HomeComponent, ChairSvgComponent, HeaderComponent],
  templateUrl: './app.component.html',
  //imports: [RouterOutlet, HeaderComponent, AssertConnectionComponent],
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'frontend';

}