
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Credential } from '../model/dto/credential';

@Injectable({
  providedIn: 'root'
})
export class CredentialService {

  private apiUrl: string = environment.apiUrl;

  constructor(
    private http: HttpClient) {
    this.apiUrl = this.apiUrl + "/credentials";
  }

  public findAll(): Observable<Credential[]> {
    return this.http.get<Credential[]>(this.apiUrl);
  }

  public findById(id: number): Observable<Credential> {
    return this.http.get<Credential>(this.apiUrl + "/" + id);
  }

  public save(credential: Credential): Observable<Credential> {
    return this.http.post<Credential>(this.apiUrl, credential);
  }

  public update(credential: Credential): Observable<Credential> {
    return this.http.put<Credential>(this.apiUrl, credential);
  }

  public deleteById(id: number): Observable<any> {
    return this.http.delete<any>(this.apiUrl + "/" + id);
  }



}







