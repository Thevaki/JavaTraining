import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private FETCH_ALL_BOOKS = "http://localhost:8080/Book/fetchAllBooks";

  constructor(private httpClient: HttpClient) { }

   public fetchAllBooks(){
    return this.httpClient.get(this.FETCH_ALL_BOOKS);
  }

  private FIND_BOOK = "http://localhost:8080/Book/findBook/1";

   public findBook(){
    return this.httpClient.get(this.FIND_BOOK);
  }
}
