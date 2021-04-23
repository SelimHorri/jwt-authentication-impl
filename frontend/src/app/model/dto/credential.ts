
import { Employee } from "./employee";

export class Credential {
  
  constructor(
    public id: number,
    public username: string,
    public password: string,
    public role: string,
    public isEnabled: boolean,
    public employee: Employee) {
    
  }
  
  
  
}






