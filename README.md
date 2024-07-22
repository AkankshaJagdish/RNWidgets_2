# RNWidgets_2

Project to create a widget for a React Native app on Android. Uses the `SharedStorage` feature from `NativeModules`. 

Here's a step-by-step guide:

1. **Setup the React Native App:**
   - Create a bare React Native app using the command: `npx react-native init RNWidgets_2`

2. **Import `NativeModules` for Android:**
   - No need to install additional libraries for Android.
   - Import `NativeModules` in your React Native component file.

3. **Use `SharedStorage` for Android:**
   - `SharedStorage` allows communication between the app and widget.
   - Store a serialized JavaScript object as a string using the `set` method.

4. **Example Code for Android:**
   ```javascript
   import { NativeModules } from 'react-native';
   const { SharedStorage } = NativeModules;

   // Store data in SharedStorage
   const widgetData = { key: 'value' };
   SharedStorage.set('widgetKey', JSON.stringify(widgetData));
   ```

5. **Implement the Android Widget:**
   - Create an Android widget in your native code (here in Java) that reads data from SharedStorage and updates the widget UI.
   - Use `SharedStorage` to retrieve the serialized data and parse it back to a JavaScript object.

6. **Build and Deploy:**
   - Build and deploy the React Native app and the Android widget together.
   - Ensure proper communication between the app and widget using the shared data stored in `SharedStorage`.


