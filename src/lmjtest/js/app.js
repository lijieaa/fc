// Dom7
var $ = Dom7;

// Theme
var theme = 'auto';
if (document.location.search.indexOf('theme=') >= 0) {
  theme = document.location.search.split('theme=')[1].split('&')[0];
}

// Init App
var app = new Framework7({
  id: 'io.framework7.testapp',
  root: '#app',
  theme: "ios",
  data: function () {
    return {
      user: {
        firstName: 'John',
        lastName: 'Doe',
      },
    };
  },
  methods: {
    helloWorld: function () {
      console.log("aaaaaaa")
      app.dialog.alert('Hello World!');
    },
  },
  routes: routes,
  statusbar: {
    enabled:false,
    overlay:false,
    iosBackgroundColor:"#018c53",
    materialBackgroundColor:"#018c53",
    iosOverlaysWebView: true,
  },
  overlay:false,
  vi: {
    placementId: 'pltd4o7ibb9rc653x14',
  },
});

console.log(app)
