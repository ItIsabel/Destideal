import { Routes } from '@angular/router';

export const routes: Routes = [
    { path: 'cities', loadComponent: () => import('./cities/city-list/city-list.component').then(m => m.CityListComponent)},
    { path: '**', redirectTo: 'cities' }
];
