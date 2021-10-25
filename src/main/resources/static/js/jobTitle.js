/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(jobTitle, status){
			
			$('#idEdit').val(jobTitle.id);
			$('#nameEdit').val(jobTitle.description);
			$('#detailsEdit').val(jobTitle.details);
			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (jobTitle, status) {
			$('#idDetails').val(jobTitle.id);
			$('#nameDetails').val(jobTitle.description);
			$('#detailsDetails').val(jobTitle.details);
		});
		$('#detailsModal').modal();
	});
	
	
	
	$('.table #deleteButton').on('click', function(event) {
		event.preventDefault();
		var href= $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
		
	});
	
	
});
$