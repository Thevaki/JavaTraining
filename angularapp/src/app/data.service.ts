import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
//import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient: HttpClient) { }

  private FETCH_ALL_BOOKS = "http://localhost:8762/book/Book/fetchAllBooks";

   public fetchAllBooks(){
      const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.FETCH_ALL_BOOKS,options);
  }

  private FIND_BOOK = "http://localhost:8762/book/Book/findBook/1";

   public findBook(){
    const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };
    return this.httpClient.get(this.FIND_BOOK,options);
  }

  private CREATE_USER = "http://localhost:8762/user/User/createUser";

  createUser(user){
      const idToken = localStorage.getItem("id_token");
      console.log(idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': idToken });
      let options = { headers: headers };

      return this.httpClient.post(this.CREATE_USER,user,options);
  }

  private CREATE_BOOK = "http://localhost:8762/book/Book/createBook";

  createBook(book){
      const idToken = localStorage.getItem("id_token");
      console.log("Token "+idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': "Bearer "+idToken });
      let options = { headers: headers };

      return this.httpClient.post(this.CREATE_BOOK,book,options);
  }

  private FETCH_ALL_USERS = "http://localhost:8762/user/User/fetchAllUsers";

   public fetchAllUsers(){
    const idToken = localStorage.getItem("id_token");
      console.log("Token "+idToken);

      let headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': "Bearer "+idToken });
      let options = { headers: headers };

    return this.httpClient.get(this.FETCH_ALL_USERS,options);
   }
  

  /*login_2(user){
    console.log("DS called ");

    this.httpClient.post<any>(this.LOGIN, user, {observe: 'response'}).subscribe(
    (resp => {
      console.log("method called ");

      console.log("headers "+resp.headers.keys());
      console.log("DS "+resp.headers.get('authorization'));

      localStorage.setItem('id_token', resp.headers.get('authorization'));
    }),
    (error) => alert("cannot connect to server. Try again"));
  }*/

  private returnedData;

  private LOGIN = "http://localhost:8762/auth";

  login(user){
    console.log("DS called ");

    this.returnedData = this.httpClient.post(this.LOGIN, user, {observe: 'response'});
    return this.returnedData;
  }

}
