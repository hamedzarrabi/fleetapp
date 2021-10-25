/**
 * 
 */

$('document').ready(function(){
	
	$('.table #editButton').on('click', function(event){
		
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(invoiceStatus, status){
			
			$('#idEdit').val(invoiceStatus.id);
			$('#nameEdit').val(invoiceStatus.description);
			$('#detailsEdit').val(invoiceStatus.details);
			
		});
		$('#editModal').modal();
	});

	$('.table #detailsButton').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$.get(href, function (invoiceStatus, status) {
			$('#idDetails').val(invoiceStatus.id);
			$('#nameDetails').val(invoiceStatus.description);
			$('#detailsDetails').val(invoiceStatus.details);
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