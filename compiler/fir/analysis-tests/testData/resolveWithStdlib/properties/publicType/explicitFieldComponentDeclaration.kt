class A {
    val a = 20

    val it: Number
        field = 4

    <!PROPERTY_MUST_HAVE_GETTER!>val joke: Number
        field = "Haha"<!>

    <!PROPERTY_MUST_HAVE_GETTER!>val incompatible: Number
        field: Any? = 42<!>

    <!PROPERTY_MUST_HAVE_GETTER!>val customGetterNeeded: Int
        field: Number = 42<!>

    val invertedTypes: Int
        field: Number = 42
        get() = 30

    val uninitialized: Number
        <!PROPERTY_FIELD_DECLARATION_MISSING_INITIALIZER!>field: Int<!>

    val uninitializedWithGetter: Number
        <!PROPERTY_FIELD_DECLARATION_MISSING_INITIALIZER!>field: Int<!>
        get() = 2

    val initiaizedWithExplicitBackingField = <!PROPERTY_INITIALIZER_WITH_EXPLICIT_FIELD_DECLARATION!>listOf(1, 2)<!>
        <!PROPERTY_FIELD_DECLARATION_MISSING_INITIALIZER!>field: MutableList<Int><!>

    val p = 5
        get() = field

    fun test() = it + 3
}

fun test() {
    val b = A().p + 2
    val c = A().it <!UNRESOLVED_REFERENCE!>+<!> 1
    val d = test()
}
