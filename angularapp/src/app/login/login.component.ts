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

    save(){
      	var userLogin = {
        	"username" : this.txtUsername,
        	"password":this.txtPassword
    	};

    	console.log("Login form success "+this.txtUsername + this.txtPassword);

    	this.dataService.login(userLogin).subscribe(
        	/*(data: any[]) => {
            	 //this.returnedData = data; 
            	 //console.log("jwt "+this.returnedData.jwt);
            	 this.result = "You have succesfully logged in";
            	 //localStorage.setItem('id_token', this.returnedData.jwt);
            	 //this.router.navigate(['books']);
           	},*/
        	(response) => {
    			//console.log("response "+response.status);  
          // response.headers.keys().map( (key) => console.log(`${key}: ${response.headers.get(key)}`)); 
          console.log("res "+response);
    			this.result = "Try again";
  			}
		); 
  	}

    save_2(){
        var userLogin = {
          "username" : this.txtUsername,
          "password":this.txtPassword
      };

      console.log("Login form success "+this.txtUsername + this.txtPassword);

      this.dataService.login_2(userLogin);
      this.test = this.dataService.login_2(userLogin);
      console.log("LS"+this.test);
    
    }

}
