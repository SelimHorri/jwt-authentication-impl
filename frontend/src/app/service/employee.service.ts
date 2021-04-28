
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthenticationRequest } from '../model/dto/authentication-request';
import { AuthenticationResponse } from '../model/dto/authentication-response';
import { Employee } from '../model/dto/employee';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  
  private apiUrl: string = environment.apiUrl;
  private token!: string;
  
  constructor(
    private authenticationService: AuthenticationService,
    private http: HttpClient) {
    this.apiUrl = this.apiUrl + "/employees";
  }
  
  public findAll(authenticationRequest: AuthenticationRequest): Observable<Employee[]> {
    
    this.authenticationService.authenticate(authenticationRequest).subscribe(
      (response: AuthenticationResponse) => {
        
        this.token = response.jwt;
        
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        alert("WTHHHHHHH");
      }
    );
    
    let httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.token}`
    });
    
    return this.http.get<Employee[]>(this.apiUrl, { headers: httpHeaders });
  }
  
  public findById(id: number): Observable<Employee> {
    return this.http.get<Employee>(this.apiUrl + "/" + id);
  }
  
  public save(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(this.apiUrl, employee);
  }
  
  public update(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(this.apiUrl, employee);
  }
  
  public deleteById(id: number): Observable<any> {
    return this.http.delete<any>(this.apiUrl + "/" + id);
  }
  
  
  
}







