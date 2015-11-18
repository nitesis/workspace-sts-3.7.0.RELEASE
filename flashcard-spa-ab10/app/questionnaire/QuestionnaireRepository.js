/**
 * 
 */
app.service('QuestRepoService', function() {
	

	var questionnaires = [
	{id:1, title: 'Q1', description: 'Lorem ipsum...'}, 
	{id:2, title: 'Q2', description: 'Lorem ipsum...'}, 
	{id:3, title: 'Q3', description: 'Lorem ipsum...'}
	
	];

	this.getAll = function () {
		
		return questionnaires;
	};
	
	this.add = function(newQuestTitle){
		var newQuestionnaire = {id: questionnaires.length + 1, title: newQuestTitle, description : 'Lorem...'};
		questionnaires.push(newQuestionnaire);
	};

});

app.factory() {
	
});