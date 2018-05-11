/**
 * System configuration for Angular samples
 * Adjust as necessary for your application needs.
 */
(function (global) {
  System.config({
    paths: {
      // paths serve as alias
      'npm:': 'node_modules/'
    },
    // map tells the System loader where to look for things
    map: {
      // our app is within the app folder
      app: 'app',
      // angular bundles
      '@angular/core': 'npm:@angular/core@2.4.9/bundles/core.umd.js',
      '@angular/common': 'npm:@angular/common@2.4.9/bundles/common.umd.js',
      '@angular/compiler': 'npm:@angular/compiler@2.4.9/bundles/compiler.umd.js',
      '@angular/platform-browser': 'npm:@angular/platform-browser@2.4.9/bundles/platform-browser.umd.js',
      '@angular/platform-browser-dynamic': 'npm:@angular/platform-browser-dynamic@2.4.9/bundles/platform-browser-dynamic.umd.js',
      '@angular/http': 'npm:@angular/http@2.4.9/bundles/http.umd.js',
      '@angular/router': 'npm:@angular/router@3.4.9/bundles/router.umd.js',
      '@angular/forms': 'npm:@angular/forms@2.4.9/bundles/forms.umd.js',
      '@angular/upgrade': 'npm:@angular/upgrade@2.4.9/bundles/upgrade.umd.js',
      // other libraries
      //'rxjs-compat':                      'npm:rxjs-compat@6.0.0',
      'rxjs':                      'npm:rxjs@5.5.4',
      'angular-in-memory-web-api': 'npm:angular-in-memory-web-api@2.4.9/bundles/in-memory-web-api.umd.js'
    },
    // packages tells the System loader how to load when no filename and/or no extension
    packages: {
      app: {
        main: './main.js',
        defaultExtension: 'js'
      },
      rxjs: {
        defaultExtension: 'js',
          main: 'Rx.js'
      }
    }
  });
})(this);
