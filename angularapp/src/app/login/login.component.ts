import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

    private txtUsername:String;
    private txtPassword:String;
    
    private data:any[];
    returnedData: any;
    test;


    constructor(private dataService: DataService,private router: Router) { }

    result: string;

    ngOnInit() {}

    /*save_2(){
        var userLogin = {
          "username" : this.txtUsername,
          "password":this.txtPassword
      };
      console.log("Login form success "+this.txtUsername + this.txtPassword);
      this.dataService.login_2(userLogin);
      this.router.navigate(['books']);
    }*/

    save(){
        var userLogin = {
          "username" : this.txtUsername,
          "password":this.txtPassword
      };
      
      this.dataService.login(userLogin).subscribe(
          (data: any[]) => {
               this.returnedData = data;
               console.log("jwt "+this.returnedData.headers.get('authorization'));
               localStorage.setItem('id_token', this.returnedData.headers.get('authorization'));
               console.log(localStorage.getItem("id_token"));
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
