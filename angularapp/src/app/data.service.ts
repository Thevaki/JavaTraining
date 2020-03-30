import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
//import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private FETCH_ALL_BOOKS = "http://localhost:8762/book/Book/fetchAllBooks";

  constructor(private httpClient: HttpClient) { }

   public fetchAllBooks(){
    return this.httpClient.get(this.FETCH_ALL_BOOKS);
  }

  private FIND_BOOK = "http://localhost:8762/book/Book/findBook/1";

   public findBook(){
    return this.httpClient.get(this.FIND_BOOK);
  }

  private CREATE_USER = "http://localhost:8762/user/User/createUser";

  createUser(user){
      const idToken = localStorage.getItem("id_token");
      console.log("Token "+idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': "Bearer "+idToken });
      let options = { headers: headers };

      return this.httpClient.post(this.CREATE_USER,user,options);
  }

  private LOGIN = "http://localhost:8762/auth";
  
  private returnedData;
  
  login(user){
    console.log("Logged in user in service layer"+user.username);

    this.returnedData = this.httpClient.post(this.LOGIN,user,{observe: 'response'});
    //console.log("jwt "+this.returnedData.response.headers.keys);
    //console.log("Auth " + this.returnedData.authorization); 
    //console.log("jwt "+res);
    console.log("resp "+this.returnedData.headers);
    (error) => alert("cannot connect to server"+this.httpClient);
    return this.httpClient.post(this.LOGIN,user);;
  }

  login_2(user){
  this.httpClient.get<any>(this.LOGIN, {observe: 'response'})
  .subscribe(resp => {
    console.log("DS "+resp.headers.get('authorization'));
  });
  }

}
