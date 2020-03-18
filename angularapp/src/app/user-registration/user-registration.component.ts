import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  constructor(private dataService: DataService) { }

  ngOnInit() {}

  public createUser(){
  var user = {
       "userId" : 4,
      "userName" : "ang",
      "password":"456",
      "nicNo":"436456b",
      "address":"345345",
      "telephoneNo":34534534
    }

    this.dataService.createUser(user).subscribe((res)=>{
      console.log("Created a customer");
    });
  }


}
