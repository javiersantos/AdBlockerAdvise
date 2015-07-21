# AdBlockerAdvise

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AdBlockerAdvise-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2175)

Android Library to check if there is an Ad Blocker enabled and shows a customizable dialog.

AdBlockerAdvise works on API 8+.

![AdBlockerAdvise](http://i.imgur.com/9mUT216.png)

## How to include
Add this line to your **build.gradle**:
```Java
dependencies {
	compile 'com.github.javiersantos.adblockeradvise:library:1.0'
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
