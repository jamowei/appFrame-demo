import dev.fritz2.components.*
import dev.fritz2.dom.html.H
import dev.fritz2.dom.html.RenderContext
import dev.fritz2.dom.html.render
import dev.fritz2.routing.router

fun main() {
    val pages = object {
        val main = "main"
        val second = "second"
        val third = "third"
    }

    val router = router(pages.main)

    render {
        appFrame {
            brand {
                lineUp({
                    alignItems { center }
                }) {
                    spacing { tiny }
                    items {
                        icon { fromTheme { fritz2 } }
                        h3 { +"AppFrame" }
                    }
                }
            }
            header {
                div {
                    +"Header Title"
                }
            }
            actions {
                clickButton {
                    icon { add }
                }
                clickButton {
                    icon { delete }
                }
                clickButton {
                    icon { barChart }
                }
            }
            navigation {
                menu {
                    link {
                        text("Main Page")
                        href("#${pages.main}")
                    }
                    link {
                        text("Second Page")
                        href("#${pages.second}")
                    }
                    link {
                        text("Third Page")
                        href("#${pages.third}")
                    }
                }
            }
            complementary {
                pushButton {
                    icon { logOut }
                    text("Log out")
                }
            }
            content {
                router.data.renderElement {
                    when (it) {
                        pages.main -> mainPage()
                        pages.second -> secondPage()
                        pages.third -> thirdPage()
                        else -> h1 { +"404 not found" }
                    }
                }
            }
            tablist {
                clickButton {
                    text("Tab 1")
                    variant { ghost }
                }
                clickButton {
                    text("Tab 2")
                    variant { ghost }
                }
            }
        }
    }
}

fun RenderContext.mainPage(): H {
    return h1 { +"Main Page Content" }
}

fun RenderContext.secondPage(): H {
    return h1 { +"Second Page Content" }
}

fun RenderContext.thirdPage(): H {
    return h1 { +"Third Page Content" }
}