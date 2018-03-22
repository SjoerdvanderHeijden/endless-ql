import { TestBed, async } from '@angular/core/testing';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import {QuestionControlService} from './services/question-control.service';
import {DynamicFormQuestionComponent} from './components/dynamic-form-question/dynamic-form-question.component';
import {BrowserModule} from '@angular/platform-browser';
import * as mockData from './ql-mock-input';
import {MaterialModule} from './material.module';
import {StyledFormContentComponent} from './components/styled-form-content/styled-form-content.component';
import {WidgetComponent} from './components/widget/widget.component';
import {ParseService} from './services/parse.service';
import {CheckboxWidgetComponent} from './components/widgets/checkbox-widget/checkbox-widget.component';
import {RadioWidgetComponent} from './components/widgets/radio-widget/radio-widget.component';
import {SpinboxWidgetComponent} from './components/widgets/spinbox-widget/spinbox-widget.component';
import {SelectWidgetComponent} from './components/widgets/select-widget/select-widget.component';
import {SliderWidgetComponent} from './components/widgets/slider-widget/slider-widget.component';
import {TextWidgetComponent} from './components/widgets/text-widget/text-widget.component';

describe('AppComponent', () => {
  let app: AppComponent;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        DynamicFormQuestionComponent,
        StyledFormContentComponent,
        WidgetComponent,
        CheckboxWidgetComponent,
        RadioWidgetComponent,
        SelectWidgetComponent,
        SliderWidgetComponent,
        SpinboxWidgetComponent,
        TextWidgetComponent
      ],
      imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        MaterialModule
      ],
      providers: [QuestionControlService, ParseService]
    }).compileComponents();
  }));

  beforeEach(() => {
    const fixture = TestBed.createComponent(AppComponent);
    app = fixture.debugElement.componentInstance;
  });

  it('should parse input', () => {
    app.inputQl = mockData.validFormWithIf;
    app.inputQls = '';
    app.parseInput();
    expect(app.formName).toBe('form');
    expect(app.questions.length).toBe(5);
    expect(app.form).toBeDefined();
    expect(app.errorMessage).toBeUndefined();
  });

  it('should prefill example input and parse that', () => {
    app.prefillForm();
    app.parseInput();
    expect(app.formName).toBe('form');
    expect(app.qlForm).toBeDefined();
    expect(app.qlsStylesheet).toBeDefined();
  });

  it('should deal with a parser error', () => {
    app.inputQl = mockData.formWrongQuestionName;
    app.parseInput();
    expect(app.formName).toBeUndefined();
    expect(app.errorMessage).toBeDefined();
  });

  it('should deal with a duplicate identifier error', () => {
    app.inputQl = mockData.duplicateIdentifierForm;
    app.parseInput();
    expect(app.formName).toBeUndefined();
    expect(app.errorMessage).toBeDefined();
  });
});
