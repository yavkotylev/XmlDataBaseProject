let $oldTitle := "Seven Steps to Rendezvous with the Casual User."
let $newTitle := "Pidor"
let $node := doc("dblp")/*/*[./title = $oldTitle]
return replace value of node $node/title with $newTitle