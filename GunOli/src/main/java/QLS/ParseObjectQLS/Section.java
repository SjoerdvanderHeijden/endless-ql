package QLS.ParseObjectQLS;

import QLS.Analysis.WidgetVisitorInterface;
import com.sun.tools.jdeps.Analyzer;

import java.util.ArrayList;

public class Section extends QLSNode {

   private String sectionName;
   private ArrayList<QLSQuestion> questions;
   private ArrayList<Section> sections;
   private ArrayList<Default> defaultSection;

   public Section(String sectionName, ArrayList<QLSQuestion> questions,
                  ArrayList<Section> sections, ArrayList<Default> defaultSection, int line){
       super(line);

       setSectionName(sectionName);
       setQuestions(questions);
       setSections(sections);
       setDefaultSection(defaultSection);

   }


    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public ArrayList<QLSQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<QLSQuestion> questions) {
        this.questions = questions;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public ArrayList<Default> getDefaultSection() {
        return defaultSection;
    }

    public void setDefaultSection(ArrayList<Default> defaultSection) {
        this.defaultSection = defaultSection;
    }

    @Override
    public <T> T accept(WidgetVisitorInterface<T> visitor) {
        return visitor.visit(this);
    }
}
