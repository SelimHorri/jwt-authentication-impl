
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthenticationRequest } from 'src/app/model/dto/authentication-request';
import { AuthenticationResponse } from 'src/app/model/dto/authentication-response';
import { Employee } from 'src/app/model/dto/employee';
import { AuthenticationService } from 'src/app/service/authentication.service';
import { EmployeeService } from 'src/app/service/employee.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  private authenticationRequest: AuthenticationRequest = new AuthenticationRequest("selimhorri", "0000");
  public jwt!: string;
  public employees!: Employee[];
  
  constructor(private authenticationService: AuthenticationService, private employeeService: EmployeeService) {
    
  }
  
  ngOnInit(): void {
    // this.authenticate(this.authenticationRequest);
    this.findAll(this.authenticationRequest);
  }
  
  public authenticate(authenticationRequest: AuthenticationRequest): void {
    this.authenticationService.authenticate(authenticationRequest).subscribe(
      (response: AuthenticationResponse) => {
        this.jwt = response.jwt;
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    );
  }
  
  public findAll(authenticationRequest: AuthenticationRequest): void {
    this.employeeService.findAll(this.authenticationRequest).subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
        alert(error.message);
      }
    );
  }
  
  
  
}



