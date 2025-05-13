import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { City } from './model/City';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CityService {
  constructor(
    private http: HttpClient
) {}

private baseUrl = 'http://localhost:8080/cities';


getCitiesByCountry(request): Observable<City[]> {
  const country = request.country;
  console.log(request)
  return this.http.post<City[]>(`${this.baseUrl}/${country}`, request);
}

  // Método para conectar con el endpoint definido
  testConexion(): Observable<string> {
    return this.http.get(`${this.baseUrl}`, { responseType: 'text' });
  }
}


