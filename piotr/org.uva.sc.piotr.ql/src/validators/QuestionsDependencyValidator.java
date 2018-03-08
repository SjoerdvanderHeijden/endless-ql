package validators;

import ast.model.expressions.values.VariableReference;
import ast.model.statements.Question;

import java.util.*;

public class QuestionsDependencyValidator {

    public HashMap<String, Node> nodes = new HashMap<>();

    static class Node {
        private final Question question;
        private final HashSet<Edge> inEdges;
        private final HashSet<Edge> outEdges;

        Node(Question question) {
            this.question = question;
            this.inEdges = new HashSet<>();
            this.outEdges = new HashSet<>();
        }

        public Node addEdge(Node node) {
            Edge e = new Edge(this, node);
            this.outEdges.add(e);
            node.inEdges.add(e);
            return this;
        }

        @Override
        public String toString() {
            return question.getVariableName();
        }
    }

    static class Edge {
        private final Node from;
        private final Node to;

        Edge(Node from, Node to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object obj) {
            Edge e = (Edge) obj;
            return e.from == from && e.to == to;
        }
    }

    public QuestionsDependencyValidator(HashMap<Question, ArrayList<VariableReference>> questionsMap) {

        Set<Question> questions = questionsMap.keySet();

        // create nodes
        for (Question question : questionsMap.keySet()) {
            this.nodes.put(question.getVariableName(), new Node(question));
        }

        // create edges
        for (Map.Entry<Question, ArrayList<VariableReference>> entry : questionsMap.entrySet()) {

            Node referringNode = this.nodes.get(entry.getKey().getVariableName());

            // for each given question (entry)

            ArrayList<VariableReference> refs = entry.getValue();

            for(VariableReference reference: entry.getValue()) {
                // find variables that it refers to

                // find node by name
                Node referredNode = nodes.get(reference.getName());

                if (referredNode != null) {
                    referringNode.addEdge(referredNode);
                }

                        //findOneByName(reference.getName());

            }


        }


        // find in questionsMap all references to a question

        // find the node containing a question with the exact same name as referenceVar

        // for each node
        // get all references
        // for each reference
        // find all ref.nodes
        // create edge node <-> ref.node


//
//
//
//            // create edges
//            for (Map.Entry<Question, ArrayList<VariableReference>> entry : questionsMap.entrySet()) {
//
//                for (VariableReference reference : entry.getValue()) {
//
//                    // find all ref.nodes
//                    for (Map.Entry<Question, Node> nodeEntry : this.nodes.entrySet()) {
//                        if (question.getVariableName().equals(reference.getName())) {
//                            Node referredNode = this.nodes.get(question);
//                            entry
//                        }
//                    }
//
//
//                }
//            }
//

    }


}
