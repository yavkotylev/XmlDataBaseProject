let $title := "%s"
let $authors := ("%s")
let $year := %s

let $node := doc("dblp.xml")/*

let $authorNodes :=
 (for $author in $authors
  return <author>{$author}</author>)

let $publication := (
<article>
   <title>{$title}</title>
    {$authorNodes}
   <year>{$year}</year></article>
)

return insert node $publication into $node
