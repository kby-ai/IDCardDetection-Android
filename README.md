<p align="center">
  <a href="https://play.google.com/store/apps/dev?id=7086930298279250852" target="_blank">
    <img alt="" src="https://github-production-user-asset-6210df.s3.amazonaws.com/125717930/246971879-8ce757c3-90dc-438d-807f-3f3d29ddc064.png" width=500/>
  </a>  
</p>

### Our facial recognition algorithm is globally top-ranked by NIST in the FRVT 1:1 leaderboards. <span><img src="https://github.com/kby-ai/.github/assets/125717930/bcf351c5-8b7a-496e-a8f9-c236eb8ad59e" alt="badge" width="36" height="20"></span>  
[Latest NIST FRVT evaluation report 2024-12-20](https://pages.nist.gov/frvt/html/frvt11.html)  

![FRVT Sheet](https://github.com/user-attachments/assets/16b4cee2-3a91-453f-94e0-9e81262393d7)

#### 🆔 ID Document Liveness Detection - Linux - [Here](https://web.kby-ai.com)  <span><img src="https://github.com/kby-ai/.github/assets/125717930/bcf351c5-8b7a-496e-a8f9-c236eb8ad59e" alt="badge" width="36" height="20"></span>
#### 🤗 Hugging Face - [Here](https://huggingface.co/kby-ai)
#### 📚 Product & Resources - [Here](https://github.com/kby-ai/Product)
#### 🛟 Help Center - [Here](https://docs.kby-ai.com/help/product/id-card-sdk)
#### 💼 KYC Verification Demo - [Here](https://github.com/kby-ai/KYC-Verification-Demo-Android)
#### 🙋‍♀️ Docker Hub - [Here](https://hub.docker.com/u/kbyai)

# IDCardDetection-Android
## Overview

This repository demonstrates `ID document detection`, `ID card detector`, `ID card scanner and reader` `ID document scanner and reader`, and `passport reader` technology developed by `KBY-AI`.

> In this repository, we integrated `KBY-AI`'s `ID document detection` solution into `Android` native platform.</br>
## Try the APK

### Google Play

<a href="https://play.google.com/store/apps/details?id=com.kbyai.idcardrecognition" target="_blank">
  <img alt="" src="https://user-images.githubusercontent.com/125717930/230804673-17c99e7d-6a21-4a64-8b9e-a465142da148.png" height=80/>
</a>

## Screenshots

<p float="left">
  <img src="https://github.com/user-attachments/assets/01cf09e4-2897-4cdc-8925-4f5d821e14a7" width=240/>
  <img src="https://github.com/user-attachments/assets/97fe33d6-c311-4a58-8c7e-bf44d6733962" width=240/>
</p>

### ◾ID Card Detection SDK Main Functionalities

  | Surpported ID Type      | Functionalities | Release Type |
  |------------------|------------------|------------------|
  | ID Card        | Detecting Front/Back Side   | Android(`Kotlin & Java`) |
  | Passport        | Extracting ID Document's Coordinates    | Web Front-end(`Javascript`) |
  | Driver License        | Auto Capturing    | Server-Linux(`Python`) |
  |         | Supporting 200+ Countries' ID Documents        |  |

### ◾ID Card Recognition Product List
  | No.      | Repository | Release Type |
  |------------------|------------------|------------------|
  | 1        | [ID Card Recognition - Android](https://github.com/kby-ai/IDCardRecognition-Android)    | Android |
  | 2        | [ID Card Recognition - iOS](https://github.com/kby-ai/IDCardRecognition-iOS)    | iOS |
  | 3        | [ID Card Recognition - Flutter](https://github.com/kby-ai/IDCardRecognition-Flutter)    | Flutter |
  | 4        | [ID Auto Capture - React](https://github.com/kby-ai/ID-document-capture-React)    | Web Front-end |
  | 5        | [ID Card Recognition - Windows](https://github.com/kby-ai/IDCardRecognition-Windows)        | Server-Windows |
  | 6        | [ID Card Recognition - Linux](https://github.com/kby-ai/IDCardRecognition-Docker)        | Server-Linux |
  | 7        | [ID Card Recognition - C#](https://github.com/kby-ai/IDCardRecognition-CSharp-.NET)        | Server-Windows |
  | ➡️        | <b>[ID Card Detection - Android](https://github.com/kby-ai/IDCardDetection-Android)</b>    | <b>Android</b> |
  

## SDK License

- The code line below shows how to update SDK with the `license key`: https://github.com/kby-ai/IDCardDetection-Android/blob/de499ea57181ced13efa67ffe0b78a2a43178a9b/app/src/main/java/com/kbyai/iddetect/CameraActivityKt.kt#L48-L56
- To request `license key`, please contact us:</br>
🧙`Email:` contact@kby-ai.com</br>
🧙`Telegram:` [@kbyai](https://t.me/kbyai)</br>
🧙`WhatsApp:` [+19092802609](https://wa.me/+19092802609)</br>
🧙`Discord:` [KBY-AI](https://discord.gg/CgHtWQ3k9T)</br>
🧙`Teams:` [KBY-AI](https://teams.live.com/l/invite/FBAYGB1-IlXkuQM3AY)</br>

## How To Run
  Try to build this repo on `Android Studio` by linking real `Android` phone, not `simulator`. Once it works fine, you are ready to integrate our `SDK` to your project.</br>

## About SDK

### 1. Set up
1. Try to build this repo on `Android Studio` to make sure that `SDK` works fine by linking real `Android` phone, not `simulator`. Once it works fine, you are ready to integrate our `SDK` to your project.</br>
And then copy the `SDK`(folder `iddetectsdk`) to the `root` folder in your project.

2. Add `SDK` to the project in `settings.gradle`.
```bash
include ':iddetectsdk'
```

3. Add dependency to your `build.gradle`.
```bash
implementation project(path: ':iddetectsdk')
```

### 2. Initializing the SDK

- Step One

To begin, you need to activate the SDK using the `license key` that you have received.
```kotlin
IDSDK.setActivation("...")
```

If activation is successful, SDK would return `SDK_SUCCESS`. Otherwise, it would return an error message.

- Step Two

Once activation is successful, you can call initialization function supported by our SDK.
```kotlin
IDSDK.init(getAssets());
```
If initialization is successful, SDK would return `SDK_SUCCESS`. Otherwise, it would return an error message.
