
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
  
  constructor(
    private authenticationService: AuthenticationService,
    private http: HttpClient) {
    this.apiUrl = this.apiUrl + "/employees";
  }
  
  public findAll(authenticationRequest: AuthenticationRequest): Observable<Employee[]> {
    
    this.authenticationService.authenticate(authenticationRequest).subscribe(
      (response: AuthenticationResponse) => {
        
        /*
        const httpHeaders = {
          headers: new HttpHeaders().set('Authorization', `Bearer ${response.jwt}`)
        }
        */
        // console.log(httpHeaders.headers.get('Authorization'));
        let httpHeaders = new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${response.jwt}`
        });
        
        httpHeaders = httpHeaders.set("Jwt-Token", "Bearer " + response.jwt);
        
        return this.http.get<Employee[]>(this.apiUrl, {headers: httpHeaders});
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
        return this.http.get<Employee[]>(this.apiUrl, { responseType: "json" });
      }
    );
    
    return this.http.get<Employee[]>(this.apiUrl, {responseType: "json"});
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







