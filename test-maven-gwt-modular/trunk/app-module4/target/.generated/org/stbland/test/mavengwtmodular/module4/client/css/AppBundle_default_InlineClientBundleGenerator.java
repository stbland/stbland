package org.stbland.test.mavengwtmodular.module4.client.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class AppBundle_default_InlineClientBundleGenerator implements org.stbland.test.mavengwtmodular.module4.client.css.AppBundle {
  private static AppBundle_default_InlineClientBundleGenerator _instance0 = new AppBundle_default_InlineClientBundleGenerator();
  private void appCssInitializer() {
    appCss = new com.google.gwt.resources.client.TextResource() {
      // file:/home/stbland/prog/java/monCode/tests/gwt/test-maven-gwt-modular/app-module4/src/main/java/org/stbland/test/mavengwtmodular/module4/client/css/app.css
      public String getText() {
        return "#main {\n	position: absolute;\n	left: 300px;\n	top: 0px;\n	right: 0px;\n	bottom: 0px;\n	overflow: hidden;\n	border-left: 1px solid black;\n}\n\n#nav {\n	position: absolute;\n	left: 0px;\n	top: 0px;\n	width: 300px;\n	bottom: 0px;\n	overflow: hidden;\n	border-right: 1px solid black;\n	\n	\n}\n\n\n\n@media only screen and (orientation:portrait) {\n	\n	#main {\n		left: 0px;\n		top: 0px;\n		right: 0px;\n		bottom: 0px;\n	}\n	#nav {\n		display:none;\n	}\n}";
      }
      public String getName() {
        return "appCss";
      }
    }
    ;
  }
  private static class appCssInitializer {
    static {
      _instance0.appCssInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return appCss;
    }
  }
  public com.google.gwt.resources.client.TextResource appCss() {
    return appCssInitializer.get();
  }
  private void inputCssInitializer() {
    inputCss = new com.google.gwt.resources.client.TextResource() {
      // file:/home/stbland/prog/java/monCode/tests/gwt/test-maven-gwt-modular/app-module4/src/main/java/org/stbland/test/mavengwtmodular/module4/client/css/input.css
      public String getText() {
        return ".mgwt-TextBox .box,.mgwt-PasswordTextBox .box {\n	color: #777;\n	width: 100%;\n	height: 32px;\n}";
      }
      public String getName() {
        return "inputCss";
      }
    }
    ;
  }
  private static class inputCssInitializer {
    static {
      _instance0.inputCssInitializer();
    }
    static com.google.gwt.resources.client.TextResource get() {
      return inputCss;
    }
  }
  public com.google.gwt.resources.client.TextResource inputCss() {
    return inputCssInitializer.get();
  }
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static com.google.gwt.resources.client.TextResource appCss;
  private static com.google.gwt.resources.client.TextResource inputCss;
  
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      appCss(), 
      inputCss(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("appCss", appCss());
        resourceMap.put("inputCss", inputCss());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'appCss': return this.@org.stbland.test.mavengwtmodular.module4.client.css.AppBundle::appCss()();
      case 'inputCss': return this.@org.stbland.test.mavengwtmodular.module4.client.css.AppBundle::inputCss()();
    }
    return null;
  }-*/;
}
