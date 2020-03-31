import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

	books = [];

  constructor(private dataService: DataService) { }

  ngOnInit() {
  		this.dataService.fetchAllBooks().subscribe((data: any[])=>{
      		console.log(data);
      		this.books = data;
    	}) 
  }

}
