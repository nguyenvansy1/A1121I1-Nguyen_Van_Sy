import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryPageComponent} from "./dictionary/dictionary-page/dictionary-page.component";
import {DictionaryDetailComponent} from "./dictionary/dictionary-detail/dictionary-detail.component";


const routes: Routes = [
  {path: '', component: DictionaryPageComponent},
  {path: 'detail/:id', component: DictionaryDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
