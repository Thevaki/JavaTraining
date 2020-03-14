// import { Component } from '@angular/core';
// import { Router, RouterModule } from '@angular/router';
// import { BooksComponent } from './books/books.component';


// // [RouterModule.forRoot([
// //   { path: 'app-books', component: BooksComponent, pathMatch: 'full' }];

// @Component({
//   selector: 'app-root',
//   templateUrl: './app.component.html',
//   styleUrls: [ './app.component.css' ]
// })
// export class AppComponent  {
//   //[x: string]: any;
//   constructor(private router: Router) {}

//   clickMessage = '';

//   clickMe() {
//     console.log("wORKING");
//     this.clickMessage = 'You !';
//   }

//   goPlaces() {
//     //this.router.navigate(['/', 'app-books']);
//     this.router.navigate(['books']);
//   }
// }

// @Component({
//   selector: 'books-books',
//   template: `
//     <button (click)="onClickMe()">Click me!</button>
//     {{clickMessage}}`
// })

// export class BooksComponent {
//   constructor() { }

//   clickMessage = '';

//   clickMe() {
//     this.clickMessage = 'You !';
//   }
// }

import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';
}
