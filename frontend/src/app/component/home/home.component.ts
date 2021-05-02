
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AuthenticationRequest } from 'src/app/model/dto/authentication-request';
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
  
  constructor(private employeeService: EmployeeService) {
    
  }
  
  ngOnInit(): void {
    this.findAll(this.authenticationRequest);
  }
  
  public findAll(authenticationRequest: AuthenticationRequest): void {
    this.employeeService.findAll(authenticationRequest).subscribe(
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



