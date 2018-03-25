import * as React from 'react';
import QlsForm from "../../../form/QlsForm";
import PageNode from "../../../form/nodes/containers/PageNode";
import { Pagination, PaginationItem, PaginationLink } from 'reactstrap';
import { StyledFieldContainer } from "../styled_field_container/StyledFieldContainer";
import SectionNode from "../../../form/nodes/containers/SectionNode";
import { SectionComponent } from "../section_component/SectionComponent";

export interface QlsFormComponentProps {
  form: QlsForm;
  onChange: (identifier: string, value: any) => void;
  onChangePage: (nextPage: PageNode) => void;
  visibleFields: Set<string>;
}

export interface QlsFormComponentState {
}

export class QlsFormComponent extends React.Component<QlsFormComponentProps, QlsFormComponentState> {
  constructor(props: QlsFormComponentProps) {
    super(props);

    this.state = {};
    this.renderField = this.renderField.bind(this);
  }

  onChangePage(nextPage: PageNode, clickEvent: React.MouseEvent<HTMLElement>) {
    clickEvent.preventDefault();
    this.props.onChangePage(nextPage);
  }

  renderPaginationLinks() {
    const activePage = this.props.form.getActivePage();
    const pages: PageNode[] = this.props.form.getPages();

    return pages.map(page => {
      const isActive = typeof activePage !== 'undefined' && activePage.isEqual(page);

      return (
          <PaginationItem active={isActive} key={page.name}>
            <PaginationLink onClick={event => this.onChangePage(page, event)} href="#">
              {page.name}
            </PaginationLink>
          </PaginationItem>
      );
    });
  }

  renderField(identifier: string) {
    const field = this.props.form.getField(identifier);
    const activePage = this.props.form.getActivePage();

    if (!field || !field.isOnPage(activePage) || !this.props.visibleFields.has(field.identifier)) {
      return null;
    }

    return (
        <StyledFieldContainer
            onChange={value => this.props.onChange(field.identifier, value)}
            key={field.identifier}
            field={field}
            value={this.props.form.getState().get(field.identifier)}
        />
    );
  }

  renderSections(sections: SectionNode[]) {
    return sections.map(section => {
      return (
          <SectionComponent
              key={section.name}
              sectionNode={section}
              renderField={this.renderField}
          />
      );
    });
  }

  renderPage(page?: PageNode) {
    if (!page) {
      return null;
    }

    return (
        <div className="questionnaire-page">
          {this.renderSections(page.getFirstLevelSections())}
        </div>
    );
  }

  render() {
    return (
        <div className="form-container--styled">
          {this.renderPage(this.props.form.getActivePage())}
          <Pagination>
            {this.renderPaginationLinks()}
          </Pagination>
        </div>
    );
  }
}