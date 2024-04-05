import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

// starter 설치 이후 :
// 1. src폴더 파일 정리 - App.css / App.tsx(jsx) / index.css / index.tsx(jsx) / react-app-env.d.ts 만 남기고 삭제
// 2. App.tsx(jsx)에서 import `./App.css` / `import React from `react``만 남기고 제거
// 3. App.tsx(jsx)에서 return에 있는 요소를 제거하고 <div></div>만 작성
// 4. App.css 코드 전부 삭제
// 5. index.tsx(jsx)에서 `import reportWebVitals from './reportWebVitals'` 삭제
// 6. index.tsx(jsx)에서 주석제거 + 주석아래 코드 제거
// 7. index.css는 code 태그 스타일 삭제               

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
