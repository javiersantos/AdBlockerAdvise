<h1 align="center">AdBlockerAdvise</h1>
<h4 align="center">Android Library</h4>

<p align="center">
  <a target="_blank" href="https://android-arsenal.com/api?level=8"><img src="https://img.shields.io/badge/API-8%2B-orange.svg"></a>
  <a target="_blank" href="https://travis-ci.org/javiersantos/AdBlockerAdvise"><img src="https://travis-ci.org/javiersantos/AdBlockerAdvise.svg?branch=master"></a>
  <a target="_blank" href="http://android-arsenal.com/details/1/2175"><img src="https://img.shields.io/badge/Android%20Arsenal-AdBlockerAdvise-blue.svg"></a>
  <a target="_blank" href="https://www.paypal.me/javiersantos" title="Donate using PayPal"><img src="https://img.shields.io/badge/paypal-donate-yellow.svg" /></a>
  <a target="_blank" href="http://patreon.com/javiersantos" title="Donate using Patreon"><img src="https://img.shields.io/badge/patreon-donate-yellow.svg" /></a>
</p>

<p align="center">Android Library that checks if there is an Ad Blocker enabled and shows a customizable Material dialog.</p>

## How to include
Add the repository to your project **build.gradle**:
```Java
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

And add the library to your module **build.gradle**:
```Java
dependencies {
    compile 'com.github.javiersantos:AdBlockerAdvise:1.0.1'
}
```

## Implementation
### With default title and content
Shows an Alert Dialog if an Ad blocker is enabled, using default title and content.
```Java
AdBlockerAdviseDialog adBlockerAdvise = new AdBlockerAdviseDialog(context);
adBlockerAdvise.show();
```

### With custom title and content
Shows an Alert Dialog if an Ad blocker is enabled, using custom title and content.
```Java
AdBlockerAdviseDialog adBlockerAdvise = new AdBlockerAdviseDialog(context, title, content);
adBlockerAdvise.show();
```

### Display dialog only once
By default, AdBlockerAdviseDialog will show a dialog every time it detects an enabled Ad Blocker, but it can be set to only appear once.
```Java
AdBlockerAdviseDialog adBlockerAdvise = new AdBlockerAdviseDialog(context, ..., true);
adBlockerAdvise.show();
```

## Other features
### Retrieve if an Ad Blocker is enabled
```Java
boolean isAdBlocker = AdBlockerAdvise.isAdBlockerActivated();
```

![AdBlockerAdvise](https://raw.githubusercontent.com/javiersantos/AdBlockerAdvise/master/Screenshots/banner.png)

## License
	Copyright 2015 Javier Santos
	
	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
