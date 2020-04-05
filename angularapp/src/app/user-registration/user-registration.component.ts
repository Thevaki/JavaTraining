import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit{

    private userId:number;
    private txtUsername:String;
    private txtPassword:String;
    private txtNicNo:String;
    private txtAddress:String;
    private txtTelephone:String;

    private data:any[];

    constructor(private dataService: DataService,private router: Router) { }

    result: string;

    ngOnInit() {}

    save(){
        var user = {
          "userId":this.userId,
          "username" : this.txtUsername,
          "password":this.txtPassword,
          "nicNo":this.txtNicNo,
          "address":this.txtAddress,
          "telephoneNo":this.txtTelephone,
          "role":"user"
        };

        console.log("Form creation data "+this.txtUsername + this.txtPassword);
      
        /*this.dataService.createUser(user).subscribe(
          (data: any[]) => this.data = data,
          (error) => alert("cannot connect to server")
        );*/

        this.dataService.createUser(user).subscribe(
          (data: any[]) => {
               this.data = data,
               this.result = "You have succesfully registered to the system";
               this.router.navigate(['books']);
            },
          (response) => {
              console.log("response "+response.status);   
              this.result = "Try again";
           }
        );
  }


}
