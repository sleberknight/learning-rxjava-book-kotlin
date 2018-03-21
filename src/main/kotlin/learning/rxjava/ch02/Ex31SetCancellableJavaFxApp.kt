package learning.rxjava.ch02

import io.reactivex.Observable
import javafx.application.Application
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.ToggleButton
import javafx.scene.layout.VBox
import javafx.stage.Stage


/**
 * Modifies the Ex11HotObservableJavaFxApp to remove the listener on the Toggle Me button
 * when a "Dispose!" button is clicked, which will make the Toggle Me button do nothing.
 */
fun main(args: Array<String>) {
    Application.launch(Ex31SetCancellableJavaFxApp::class.java)
}


class Ex31SetCancellableJavaFxApp : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {

        val toggleButton = ToggleButton("Toggle Me")
        val label = Label()

        val selectedStates = valuesOf(toggleButton.selectedProperty())

        val disposable = selectedStates
                .map { selected -> if (selected) "Down" else "Up" }
                .subscribe(label::setText)

        val disposeButton = ToggleButton("Dispose!")
        val disposeSelectedProperty = disposeButton.selectedProperty()
        val disposeListener = ChangeListener<Boolean> { _, _, _ -> disposable.dispose() }
        disposeSelectedProperty.addListener(disposeListener)

        val vBox = VBox(toggleButton, label, disposeButton)

        primaryStage.scene = Scene(vBox)
        primaryStage.show()
    }

    private fun <T> valuesOf(fxObservable: ObservableValue<T>): Observable<T> {
        return Observable.create { emitter ->

            // emit initial state
            emitter.onNext(fxObservable.value)

            // emit value changes using a listener
            val listener = ChangeListener<T> { _, _, newValue -> emitter.onNext(newValue) }

            println("Adding listener $listener")
            fxObservable.addListener(listener)

            emitter.setCancellable {
                println("Removing JavaFX listener $listener")
                fxObservable.removeListener(listener)
            }
        }
    }

}
