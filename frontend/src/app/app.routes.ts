import { Routes } from '@angular/router';
import { HomeComponent } from "./feature/home/home.component";
import { ManagementComponent } from "./feature/management/management.component";

export const routes: Routes = [
    {path: '', component: HomeComponent, pathMatch: 'full'},
    {path: 'sala', component: ManagementComponent, pathMatch: 'full'},
    { path: 'sala/:id', component: ManagementComponent }
];
