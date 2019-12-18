let $title := "%s"
return delete node doc("dblp.xml")/*/*[./title = $title]