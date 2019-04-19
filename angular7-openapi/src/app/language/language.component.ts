import { Component, OnInit } from '@angular/core';
import { LanguageControllerService, Language } from '@techshard/language-rest-api';

@Component({
  selector: 'app-language',
  templateUrl: './language.component.html',
  styleUrls: ['./language.component.scss']
})
export class LanguageComponent implements OnInit {

  languages: Language[] = [];

  constructor(private languageControllerService: LanguageControllerService) { }

  ngOnInit() {
    this.languageControllerService.getLanguagesUsingGET().subscribe(res => {
      for (var i in res) {
        this.languages.push(res[i]);
      }
    });
  }

}
