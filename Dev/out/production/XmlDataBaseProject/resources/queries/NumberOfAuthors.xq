let $authors := doc("dblp")/*/*/author

for $author in distinct-values($authors)
  let $count:= count( $authors[. = $author])
  order by $count descending
return concat($author," ",$count)