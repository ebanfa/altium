(function () {
  var app = {
      initialize: function () {
          this.bindEvents();
      },
      bindEvents: function () {
          document.addEventListener('deviceready', this.onDeviceReady, false);
      },
      onDeviceReady: function () {
    	  window.cordova.plugins.admob.createBannerView({publisherId: "ca-app-pub-1014840623939474/5528544544"});
      },
  };

  app.initialize();
})();
