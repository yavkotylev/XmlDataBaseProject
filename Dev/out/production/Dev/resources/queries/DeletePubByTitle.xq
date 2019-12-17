let $title := "%s"
return delete node doc("src/resources/xml/dblp.xml")/*/*[./title = $title]