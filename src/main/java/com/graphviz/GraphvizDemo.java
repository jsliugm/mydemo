//package com.graphviz;
//
//import guru.nidi.graphviz.attribute.*;
//import guru.nidi.graphviz.engine.Format;
//import guru.nidi.graphviz.engine.Graphviz;
//import guru.nidi.graphviz.model.Graph;
//import guru.nidi.graphviz.model.MutableGraph;
//import guru.nidi.graphviz.model.MutableNode;
//import guru.nidi.graphviz.model.SvgElementFinder;
//import guru.nidi.graphviz.parse.Parser;
//import org.junit.Test;
//
//import java.io.File;
//import java.io.IOException;
//
//import static guru.nidi.graphviz.attribute.Attributes.attr;
//import static guru.nidi.graphviz.attribute.Rank.RankDir.LEFT_TO_RIGHT;
//import static guru.nidi.graphviz.attribute.Rank.RankDir.TOP_TO_BOTTOM;
//import static guru.nidi.graphviz.model.Factory.*;
//
//public class GraphvizDemo {
//    public static void main(String[] args) throws Exception {
//        Graph g = graph("example1").directed()
//                .graphAttr().with(Rank.dir(LEFT_TO_RIGHT))
//                .nodeAttr().with(Font.name("arial"))
//                .linkAttr().with("class", "link-class")
//                .with(
//                        node("a").with(Color.RED).link(node("b")),
//                        node("b").link(
//                                to(node("c")).with(attr("weight", 5), Style.DASHED)
//                        )
//                );
//        Graphviz.fromGraph(g).height(100).render(Format.PNG).toFile(new File("e:/ex1.png"));
//
//    }
//
//    @Test
//    public void test() throws IOException {
//        Graph g = graph("example1").directed()
//                .graphAttr().with(Rank.dir(TOP_TO_BOTTOM))
//                .nodeAttr().with(Font.size(3))
//                .linkAttr().with("class", "link-class")
//                .with(
//                        node("a").with(Color.RED).with(Label.of("车龄 ＞ 10")).link(node("b"), node(">"), node("c")),
//                        node("b").with(Label.of("车龄")).link(node("d"), node("d1")),
//                        node("c").link(node("e"), node("f"))
//                );
//        Graphviz.fromGraph(g).height(4000).width(4000).render(Format.PNG).toFile(new File("e:/tree.png"));
//    }
//
//    @Test
//    public void testDot() throws IOException {
//        String dot = "digraph graph_attr\n" +
//                "{\n" +
//                "    graph[bgcolor=\"cadetblue\" label=\"图的标题\" fontsize=24 fontcolor=\"green\"];\n" +
//                "\n" +
//                "    node0 -> node1[];\n" +
//                "    node0 -> node2;\n" +
//                "}";
//        MutableGraph g = new Parser().read(dot);
//        Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("e:/dotTest.png"));
//    }
//
//    @Test
//    public void testDot2() throws IOException {
//        String dot = "digraph demo {\n" +
//                "    label=\"示例\"\n" +
//                "    bgcolor=\"beige\"\n" +
//                "\n" +
//                "    root[label=\"车龄 小于 3 或 车龄 大于 10\", shape=\"box\"]\n" +
//                "\texpr1[label=\"车龄 小于 3\",color=\"#FF6347\"]\n" +
//                "    l1[label=\"车龄\", shape=\"box\"]\n" +
//                "    op1[label=\"小于\", shape=\"circle\"]\n" +
//                "    r1[label=\"3\", shape=\"circle\"]\n" +
//                "\t\n" +
//                "\top[label=\"或\", shape=\"circle\"]\n" +
//                "\t\n" +
//                "\texpr2[label=\"车龄 大于 10\"]\n" +
//                "\tl2[label=\"车龄\", shape=\"box\"]\n" +
//                "    op2[label=\"大于\", shape=\"circle\"]\n" +
//                "    r2[label=\"10\", shape=\"circle\"]\n" +
//                "  \n" +
//                "\troot -> expr1\n" +
//                "\troot -> op\n" +
//                "\troot -> expr2\n" +
//                "\t\n" +
//                "\t\n" +
//                "\texpr1 -> l1\n" +
//                "\texpr1 -> op1\n" +
//                "\texpr1 -> r1\n" +
//                "\t\n" +
//                "\texpr2 -> l2\n" +
//                "\texpr2 -> op2\n" +
//                "\texpr2 -> r2\n" +
//                "}";
//        System.out.println(dot);
//        MutableGraph g = new Parser().read(dot);
//        Graphviz.fromGraph(g).width(700).render(Format.PNG).toFile(new File("e:/dotTest2.png"));
//    }
//
//    @Test
//    public void test101() throws Exception {
//        MutableGraph g = mutGraph("example1").use((gr, ctx) -> {
//            MutableNode root = mutNode("b");
//            root.add(Color.GREEN);
//            for (int i = 0; i < 10; i++) {
//                MutableNode in = mutNode("node" + i);
//                root.addLink(in);
//                if (i % 2 == 0) {
//                    in.add(Color.GREY1);
//                } else {
//                    in.add(Color.GREEN);
//                }
//                dd(in, 3, i);
//            }
////           nodeAttrs().add(Color.RED);
////            nodeAttrs().add(Label.of("hello"));
////            mutNode("a").addLink(mutNode("b"));
//        });
//        Graphviz.fromGraph(g).render(Format.PNG).toFile(new File("example/test101.png"));
//    }
//
//    private void dd(MutableNode in, int n, int i) {
//        if (n == 0) {
//            return;
//        }
//        MutableNode node = mutNode(i + "" + n);
//        node.add(Color.rgb(255));
//        in.addLink(node);
//        n--;
//        dd(node, n, i);
//    }
//
//    @Test
//    public void test107() throws Exception {
//        Graph graph = graph().with(node("bad word").link("good word"));
//        Graphviz g = Graphviz.fromGraph(graph)
//                .preProcessor((source, options, processOptions) -> source.replace("bad word", "unicorn"))
//                .postProcessor((result, options, processOptions) ->
//                        result.mapString(svg ->
//                                SvgElementFinder.use(svg, finder -> {
//                                    finder.findNode("unicorn").setAttribute("class", "pink");
//                                })));
//        g.render(Format.PNG).toFile(new File("example/ex9.png"));
//    }
//
//    private RuleNode prepareRuleNode() {
//        RuleNode ruleNode = new RuleNode(true, "包含");
//        ruleNode.addNode(new RuleNode("张三", "客户风险名单"));
//        ruleNode.addNode(new RuleNode("", "张"));
//        return ruleNode;
//    }
//
//    @Test
//    public void test157() throws Exception {
//        RuleNode ruleNode = prepareRuleNode();
//        MutableGraph g = mutGraph("example1").use((gr, ctx) -> {
//            dd2(ruleNode,null);
//        });
//        Graphviz.fromGraph(g).render(Format.PNG).toFile(new File("example/test157.png"));
//    }
//
//    void dd2(RuleNode ruleNode, MutableNode node) {
//        if (node == null) {
//            node = mutNode(ruleNode.getText()+"\n"+ruleNode.getResult());
//            if (Boolean.TRUE.equals(ruleNode.getResult())) {
//                node.add(Color.RED);
//            } else {
//                node.add(Color.GREEN);
//            }
//        } else {
//            MutableNode childNode = mutNode(ruleNode.getText()+"\n"+ruleNode.getResult());
//            node.addLink(childNode);
//            if (Boolean.TRUE.equals(ruleNode.getResult())) {
//                childNode.add(Color.RED);
//            } else {
//                childNode.add(Color.GREEN);
//            }
//            node = childNode;
//        }
//        if (ruleNode.getChildren().isEmpty()) {
//            return;
//        }
//        for (RuleNode child : ruleNode.getChildren()) {
//            dd2(child, node);
//        }
//    }
//}
