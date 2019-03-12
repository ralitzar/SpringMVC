$('#confirmationModal').on('show.bs.modal', function(event){
	var button=$(event.relatedTarget);
	
	var kod = button.data('kod');
	var opisanie = button.data('opisanie');
	
	var modal = $(this);
	  var form = modal.find('form');
	  var action = form.data('url-base');
		if (!action.endsWith('/')) {
			action += '/';
		}
		form.attr('action', action + kod);

		modal.find('.modal-body span').html('Сигурнили сте, че искате да изтриете плащането  на <strong>' 
				+ opisanie + '</strong>?');
});

$(function() {
	$('.js-currency').maskMoney({decimal: '.', thousands: ',', allowZero: true});
});