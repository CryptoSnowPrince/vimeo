import { requireNativeComponent } from 'react-native';

// const viewProps = {
//     name: "AdView",
//     propTypes: {
//         unitId: PropTypesA.string
//     }
// }

const AdView = requireNativeComponent('AdView');
// const AdViewModule = NativeModules.AdViewModule;

// AdView.setAdUnitId = (adUnitId) => {
//   AdViewModule.setAdUnitId(adUnitId);
// };

export default AdView;