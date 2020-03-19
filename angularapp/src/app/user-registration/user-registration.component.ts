import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

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

    constructor(private dataService: DataService) { }

    ngOnInit() {}

    save(){
      var user = {
        "userId":this.userId,
        "userName" : this.txtUsername,
        "password":this.txtPassword,
        "nicNo":this.txtNicNo,
        "address":this.txtAddress,
        "telephoneNo":this.txtTelephone
    };

    console.log("Created a customer "+this.txtUsername + this.txtPassword);
      this.dataService.createUser(user).subscribe(
        (data: any[]) => this.data = data,
        //(error) => alert("cannot connect to server")
    );
  }


}
